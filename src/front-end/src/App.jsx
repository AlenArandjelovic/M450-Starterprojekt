import AddItem from "./components/AddItem";
import ItemList from "./components/ItemList";



function App() {
  return (
    <>
      <section className="py-4">
        <AddItem />
      </section>
      <section>
        <ItemList />
      </section>
    </>
  );
}

export default App;
