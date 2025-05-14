const quotes = [
  "Java is to JavaScript what car is to Carpet. – Chris Heilmann",
  "The best way to learn Java is by writing Java. – Anonymous",
  "First, solve the problem. Then, write the code. – John Johnson",
  "Code is like humor. When you have to explain it, it’s bad. – Cory House",
  "Java has the power of C++ and the simplicity of Python. – Anonymous",
  "System.out.println(\"Hello world!\") – Every Java beginner ever",
  "Why did the Java developer go broke? Because he used up all his cache.",
  "Java: write once, debug everywhere!",
  "Real programmers count from 0. Java counts from 0 too. Coincidence?",
  "My code works... I have no idea why. Must be Java magic."
];

function displayRandomQuote() {
  const quoteElement = document.getElementById("javaQuote");
  const randomIndex = Math.floor(Math.random() * quotes.length);
  quoteElement.textContent = quotes[randomIndex];
}

window.onload = function() {
  displayRandomQuote();

  document.getElementById("newQuoteBtn").addEventListener("click", () => {
    displayRandomQuote();
  });

  const title = document.getElementById("mainTitle");
  title.addEventListener("mouseenter", () => {
    title.textContent = "Java is Love, Java is Life!";
  });
  title.addEventListener("mouseleave", () => {
    title.textContent = "Welcome to Java Features";
  });

  const features = document.querySelectorAll("#javaFeatures li");
  features.forEach(feature => {
    feature.addEventListener("mouseenter", () => {
      const sillyQuote = quotes[Math.floor(Math.random() * quotes.length)];
      feature.setAttribute("title", sillyQuote);
    });
  });
};
