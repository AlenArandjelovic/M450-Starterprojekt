const { test, expect } = require('@playwright/test');

test('page loads', async ({ page }) => {
  await page.goto('http://localhost:3000');

  await expect(page).toHaveTitle(/React|Items|App/);
});

const { test, expect } = require('@playwright/test');

test('can add item', async ({ page }) => {
  await page.goto('http://localhost:3000');

  await page.fill('input', 'Apple');
  await page.click('button');

  await expect(page.locator('text=Apple')).toBeVisible();
});