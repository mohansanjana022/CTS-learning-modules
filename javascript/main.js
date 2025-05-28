// ✅ 1. JavaScript Basics & Setup
console.log("Welcome to the Community Portal");

window.onload = function () {
  alert("Page is fully loaded!");
};

// ✅ 2. Syntax, Data Types, and Operators
const eventName = "Music Fiesta";
const eventDate = "2025-06-20";
let availableSeats = 50;

console.log(`${eventName} is scheduled for ${eventDate}. Seats left: ${availableSeats}`);
availableSeats--; // One user registered

// ✅ 3. Conditionals, Loops, and Error Handling
const events = [
  { name: "Art Fest", date: "2025-06-01", seats: 0 },
  { name: "Music Fiesta", date: "2025-06-20", seats: 20 },
];

events.forEach(event => {
  const today = new Date();
  const eventDateObj = new Date(event.date);
  if (eventDateObj > today && event.seats > 0) {
    console.log(`Event: ${event.name}`);
  } else {
    console.log(`Skipping event: ${event.name}`);
  }
});

function register(event) {
  try {
    if (event.seats <= 0) throw "No seats left!";
    event.seats--;
    console.log("Registered successfully!");
  } catch (e) {
    console.error(e);
  }
}

// ✅ 4. Functions, Scope, Closures, Higher-Order Functions
function addEvent(name, date, category, seats) {
  events.push({ name, date, category, seats });
}

function registerUser(event) {
  if (event.seats > 0) event.seats--;
}

function filterEventsByCategory(category) {
  return events.filter(e => e.category === category);
}

// Closure to track registrations
function createCategoryCounter() {
  let count = 0;
  return function () {
    count++;
    return count;
  };
}

const musicCounter = createCategoryCounter();
console.log(musicCounter()); // 1
console.log(musicCounter()); // 2

// ✅ 5. Objects and Prototypes
function Event(name, date, seats) {
  this.name = name;
  this.date = date;
  this.seats = seats;
}

Event.prototype.checkAvailability = function () {
  return this.seats > 0;
};

const e1 = new Event("Workshop", "2025-06-15", 30);
console.log(Object.entries(e1)); // Show key-value pairs

// ✅ 6. Arrays and Methods
let allEvents = [];

allEvents.push({ name: "Dance Night", category: "Music", date: "2025-06-25" });

const musicEvents = allEvents.filter(e => e.category === "Music");

const displayCards = allEvents.map(e => `${e.name} on ${e.date}`);

// ✅ 7. DOM Manipulation
const container = document.querySelector("#eventContainer");

allEvents.forEach(event => {
  const card = document.createElement("div");
  card.className = "eventCard";
  card.innerHTML = `<h3>${event.name}</h3><p>${event.date}</p>`;
  container.appendChild(card);
});

// ✅ 8. Event Handling
document.querySelectorAll(".registerBtn").forEach(btn => {
  btn.onclick = () => alert("Registered!");
});

document.querySelector("#categoryFilter").onchange = (e) => {
  const filtered = filterEventsByCategory(e.target.value);
  // Re-render cards
};

document.querySelector("#searchInput").addEventListener("keydown", (e) => {
  if (e.key === "Enter") {
    const query = e.target.value.toLowerCase();
    const results = allEvents.filter(ev => ev.name.toLowerCase().includes(query));
    // Re-render results
  }
});

// ✅ 9. Async JS, Promises, Async/Await
// events.json should be in a data folder
fetch("data/events.json")
  .then(res => res.json())
  .then(data => {
    console.log(data);
  })
  .catch(err => console.error("Error loading events", err));

// Async/await version
async function fetchEvents() {
  document.getElementById("loader").style.display = "block";
  try {
    const res = await fetch("data/events.json");
    const data = await res.json();
    console.log(data);
  } finally {
    document.getElementById("loader").style.display = "none";
  }
}

// ✅ 10. Modern JavaScript Features
const displayEvent = ({ name, date }) => {
  console.log(`${name} on ${date}`);
};

const newList = [...allEvents]; // Clone list

function greet(user = "Guest") {
  console.log(`Hello, ${user}`);
}

// ✅ 11. Working with Forms
document.getElementById("registerForm").addEventListener("submit", function (e) {
  e.preventDefault();
  const form = e.target;
  const name = form.elements["name"].value;
  const email = form.elements["email"].value;

  if (!name || !email) {
    alert("Please fill in all fields.");
    return;
  }

  console.log(`Registering ${name} with email ${email}`);
});

// ✅ 12. AJAX & Fetch API
function submitRegistration(data) {
  fetch("https://jsonplaceholder.typicode.com/posts", {
    method: "POST",
    body: JSON.stringify(data),
    headers: { "Content-Type": "application/json" }
  })
    .then(res => res.json())
    .then(() => alert("Registration successful!"))
    .catch(() => alert("Registration failed!"));
}

// ✅ 13. Debugging and Testing
// Use Chrome Dev Tools (F12)
// Use the Console tab for console.log()
// Use Network tab to inspect fetch calls
// Add debugger; in your JS code to pause execution

// ✅ 14. jQuery and JS Frameworks
// Ensure jQuery is included in your HTML:
// <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

$('#registerBtn').click(() => {
  alert("Registered via jQuery!");
});

$('.eventCard').fadeIn();

console.log("✅ Benefit of frameworks like React: Component-based structure allows efficient UI updates and code reusability.");

