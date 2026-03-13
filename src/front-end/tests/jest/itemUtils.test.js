import { addItem } from '../../src/utils/itemUtils.js';

test('addItem fügt ein Item hinzu', () => {
    const items = [];
    const result = addItem(items, "Apple");
    expect(result).toContain("Apple");
});

test('addItem erhöht die Länge des Arrays', () => {
    const items = [];
    const result = addItem(items, "Banana");
    expect(result.length).toBe(1);
});