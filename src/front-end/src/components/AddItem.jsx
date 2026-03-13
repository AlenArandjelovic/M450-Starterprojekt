import { useState } from "react";

function AddItem() {
  const [item_name, setItemName] = useState("");

  function addClicked(event) {
    event.preventDefault();

    fetch(`http://localhost:8080/items/${item_name}`, {
      method: "POST"
    }).then((response) => {
      console.log(response);
      window.location.reload();
    });
  }

  return (
    <>
      <h3>Add Item</h3>
      <form className="row">
        <div className="col-6">
          <input
            type="text"
            className="form-control"
            placeholder="Itemname"
            value={item_name}
            onChange={(e) => setItemName(e.target.value)}
          />
        </div>
        <div className="col-6">
          <button className="btn btn-primary" onClick={addClicked}>
            Add
          </button>
        </div>
      </form>
    </>
  );
}

export default AddItem;
