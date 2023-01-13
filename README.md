# Cupcake Factory

___________________

### Credits

Inspired by [codingdojo.org](https://codingdojo.org/kata/cupcake/)
___

### Goal

Write a program that can build many cakes with many toppings like:
"Cupcake with chocolate and nuts" Or "🧁 with black 🍫 and 🥜".
Be careful the order of topping is very important. <br>
Write a function or method that can show the name of cake. <br>
Write a function that can show the price of cake.
The price is composed of base cake price and topping price.

### Rules

- Use TDD
- No red phases while refactoring.

### Requirements

Cupcake creation:

- Create a Cupcake 🧁
- Add 🍫 as cupcake's topping
- Add 🥜 as second cupcake's topping
- Create a Cupcake with 🥜 and 🍫
- Add other flavours (like black 🍫, vanilla, ...)

Sold Cupcakes

- The price should return 1$ for 🧁
- The price should return 0.1$ for 🍫
- The price should return 0.2$ for 🥜

### Additional Features

## New Product

You have a new product: 🍪 <br>
The price of a 🍪 is 2$ and could have the same standard topping of 🧁 (without the added flavours)

## Bundle

Now it’s possible to make a bundle of cakes.
The price of a bundle is 10% less than prices of each Cupcake. <br>
It’s possible to build a bundle with singles Cupcake.

- We can build a Bundle with 1 Cupcake and check price or description
- We can build a Bundle with 1 Cupcake and 1 Cookie and check price or description
- We can build a Bundle with 2 Cupcake and 1 Cookie and check price or description
