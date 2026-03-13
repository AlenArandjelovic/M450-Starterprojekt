import { useState, useEffect } from "react";
import ItemRow from "./ItemRow";

function ItemList() {
  const [items, setItems] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/items")
      .then(
        (response) =>
          (response.ok && response.json()) || Promise.reject(response)
      )
      .then((data) => setItems(data))
      .catch((error) => console.error(error));
  }, []);

  return (
    <>
      <h3>Item List</h3>
      <div className="container">
        {items.map((item) => (
          <ItemRow key={item.id} item={item} />
        ))}
      </div>
    </>
  );
}

export default ItemList;
