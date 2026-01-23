import React from "react"
import {render, screen} from '@testing-library/react';
import CounterCard from "./CounterCard";
import userEvent from "@testing-library/user-event";
import { count } from "console";

// Write our tests, describe keyword identifies the component we're testing
// and includes the individual tests to run:
describe("CounterCard", () => {
  // In this function, we write individual tests
  // The test function takes in a string that describes the test
  // and a callback function that contains the test code
  test("Renders the correct content", () => {
    // Start by rendering the component in question:
    render(<CounterCard title = "Counter Test" initialCount = {2}/>);

    // Act + Assert
    // querying the component for a particular element and asserting that the correct
    // content is there
    expect(
      // Search for all heading elements (h1, h2, h3, etc.) with the value
      // "Counter Test" and expects it to be in the document
      screen.getByRole("heading", {name: "Counter Test"})
    ).toBeInTheDocument(); // will fail if element is not found

    // ensure that intialCount renders
    // expecting the rendered count to be 2 because that's what we passed in when we rendered the component
    // for this test
    expect(screen.getByLabelText("count-value")).toHaveTextContent("2");

    // Making sure the buttons appear:
    expect(
      screen.getByRole("button", {name: "Increment"})
    ).toBeInTheDocument();

    
    expect(
      screen.getByRole("button", {name: "Reset"})
    ).toBeInTheDocument();
  
  })

  test("responds to user interactions", async () => {
    // user object is used to trigger events like clicking:
    const user = userEvent.setup()

    // render the component:
    render(<CounterCard title = "User Interactions" initialCount={0}/>);

    // If we want to programatically click buttons or trigger events, we need to access those elements:
    const incrementButton = screen.getByRole("button", {name: "Increment"});
    const resetButton = screen.getByRole("button", {name: "Reset"});
    const countValue = screen.getByLabelText("count-value");

    // Trigger some events:
    await user.click(incrementButton);
    await user.click(incrementButton);

    // assert/expect the count value is now 2:
    expect(countValue).toHaveTextContent("2");
    
    // reset the button and ensure the count goes back to 0:
    await user.click(resetButton);
    expect(countValue).toHaveTextContent("0");
  })

  test("Test that state/props are synced up with view", async () => {
    const user = userEvent.setup();

    // returning a rerender function from this render call, used to re-render the component down below:
    const {rerender} = render(<CounterCard title = "Prop Sync" initialCount={5}/>);

    const incrementButton = screen.getByRole("button", {name: "Increment"});
    const countValue = screen.getByLabelText("count-value");

    // make sure if we increment the button, should be 6:
    await user.click(incrementButton);
    expect(countValue).toHaveTextContent("6");

    // If we change the prop, expect the view to be updated
    // For this, we need to re-render the component
    rerender(<CounterCard title = "Prop Sync" initialCount={42}/>);
    expect(countValue).toHaveTextContent("42");

    // TODO check if we change the title, then the view is changed



  })

})