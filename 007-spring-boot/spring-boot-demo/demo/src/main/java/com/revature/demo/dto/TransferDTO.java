package com.revature.demo.dto;

public class TransferDTO {
    private Long donorId;
    private Long recipId;
    private int amount;

    public TransferDTO(Long donorId, Long recipId, int amount) {
        this.donorId = donorId;
        this.recipId = recipId;
        this.amount = amount;
    }

    public TransferDTO() {
    }

    @Override
    public String toString() {
        return "TransferDTO{" +
                "donorId=" + donorId +
                ", recipId=" + recipId +
                ", amount=" + amount +
                '}';
    }

    public Long getDonorId() {
        return donorId;
    }

    public void setDonorId(Long donorId) {
        this.donorId = donorId;
    }

    public Long getRecipId() {
        return recipId;
    }

    public void setRecipId(Long recipId) {
        this.recipId = recipId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
