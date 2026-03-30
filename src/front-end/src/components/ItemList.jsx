// ItemList.jsx
import { useState, useEffect } from "react";
import ItemRow from "./ItemRow";

function ItemList() {
  const [items, setItems] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/items")
      .then((response) =>
        response.ok ? response.json() : Promise.reject(response)
      )
      .then((data) => {
        // Sortieren: Items mit Deadline zuerst, früheste Deadline oben
        const sorted = [...data].sort((a, b) => {
          if (!a.deadline) return 1;
          if (!b.deadline) return -1;
          return new Date(a.deadline) - new Date(b.deadline);
        });
        setItems(sorted);
      })
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