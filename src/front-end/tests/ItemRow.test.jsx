// ItemRow.test.jsx
import { render, screen } from "@testing-library/react";
import ItemRow from "./ItemRow";

test("zeigt Item rot an, wenn Deadline überschritten", () => {
  const past = new Date();
  past.setDate(past.getDate() - 1);

  render(
    <ItemRow item={{ name: "Overdue", deadline: past.toISOString(), status: "OPEN" }} />
  );

  const element = screen.getByText("Overdue");
  expect(element.parentElement).toHaveStyle("background-color: #f8d7da");
});

test("zeigt Item grün an, wenn Deadline noch nicht überschritten", () => {
  const future = new Date();
  future.setDate(future.getDate() + 1);

  render(
    <ItemRow item={{ name: "Not overdue", deadline: future.toISOString(), status: "OPEN" }} />
  );

  const element = screen.getByText("Not overdue");
  expect(element.parentElement).toHaveStyle("background-color: #d4edda");
});