package com.revature.registration.resilience;

import com.revature.registration.dtos.SeatRequest;
import com.revature.registration.exceptions.DownstreamUnavailableException;
import com.revature.registration.feign.WorkshopClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * This class will be used to wrap our calls to the other service in CircuitBreaker logic
 * allowing us to specify the timeout,retry,fallback behavior if things go wrong (if the downstream
 * service is not running/healthy)
 */
@Component
public class WorkshopGateway {
    private WorkshopClient client;

    public WorkshopGateway(WorkshopClient workshopClient) {
        this.client = workshopClient;
    }

    @CircuitBreaker(name="workshop", fallbackMethod="reserveFallback") // Indicate that we want to stop repeated calls and use the fallbackMethod when things go wrong
    @TimeLimiter(name="workshop") // using the .yml config properties, fail fast when the downstream is unresponsive
    @Retry(name="workshop") // Retry and try to recover
    // CompletableFutures are useful for concurrent programming
    // When we return a CompletableFuture, we're indicating that in some time, we'll either return the value
    // or throw some exception
    public CompletableFuture<Void> reserveSeat(Long workshopId, SeatRequest req) {
        // return a CompletableFuture, specifying the behavior we want to run (calling the methods from WorkshopClient)
        return CompletableFuture.runAsync(() -> client.reserve(workshopId, req));
    }

    @CircuitBreaker(name="workshop", fallbackMethod = "confirmFallback")
    @TimeLimiter(name="workshop")
    @Retry(name="workshop")
    public CompletableFuture<Void> confirmSeat(Long workshopId, SeatRequest req) {
        return CompletableFuture.runAsync(() -> client.confirm(workshopId, req));
    }

    @CircuitBreaker(name="workshop", fallbackMethod = "releaseFallback")
    @TimeLimiter(name="workshop")
    @Retry(name="workshop")
    public CompletableFuture<Void> releaseSeat(Long workshopId, SeatRequest req) {
        return CompletableFuture.runAsync(() -> client.release(workshopId, req));
    }

    // Fallback Methods
    // Signatures should match the same params as the corresponding method + Throwable
    private CompletableFuture<Void> reserveFallback(Long workshopId, SeatRequest req, Throwable t) {
        // .failedFuture creates CompletableFuture that contains no successful result, specify the exception
        // Later, if we try to consume this completableFuture with .join(), the exception will be thrown
        return CompletableFuture.failedFuture(new DownstreamUnavailableException("Workshop service unavailable (reserve)", t));
    }

    private CompletableFuture<Void> confirmFallback(Long workshopId, SeatRequest req, Throwable t) {
        return CompletableFuture.failedFuture(new DownstreamUnavailableException("Workshop service unavailable(confirm)", t));
    }

    private CompletableFuture<Void> releaseFallback(Long workshopId, SeatRequest req, Throwable t) {
        return CompletableFuture.failedFuture(new DownstreamUnavailableException("Workshop service unavailable(release)", t));
    }

}
