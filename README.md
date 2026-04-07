# 🌱 AgriConnect – Smart Agriculture Platform

AgriConnect is a full-stack web application designed to **empower farmers, connect buyers, and provide expert agricultural guidance**.
The platform bridges the gap between farmers and society by enabling **direct selling, smart recommendations, and real-time insights**.

---

## 🚀 Features

### 👨‍🌾 Farmer

* Add, edit, and delete crops/products
* Receive and manage buyer offers
* Accept/Reject negotiations
* Receive suggestions from agriculture experts

---

### 🛒 Public Buyer

* Browse and search farmer products
* Negotiate prices with farmers 💬
* Purchase products 
* Report users/products to admin 🚨

---

### 👨‍🔬 Agriculture Expert

* View farmers who requested guidance
* Analyze farmer details (soil, region, water availability)
* Suggest:

  * Suitable crops 🌾
  * Fertilizers
  * Pesticides
* Send recommendations directly to farmers

---

### 🛠️ Admin

* Manage all users (Farmers, Buyers, Experts)
* Delete inappropriate products
* Handle reports from buyers
* Approve new admin registrations 🔐

---

## 💰 Currency

* All prices are displayed in **Indian Rupees (₹)**
* Stored as numeric values in database and formatted in frontend

---

## 🗄️ Database

* MySQL database with structured tables:

  * Users
  * Products
  * Offers (Negotiation)
  * Orders (Payments)
  * Suggestions
  * Reports
    

---

## 🖥️ Tech Stack

### Frontend

* React.js
* Tailwind CSS / Material UI

### Backend

* Node.js / Spring Boot

### Database

* MySQL


---

## 🔐 Authentication

* Role-based registration:

  * Farmer
  * Buyer
  * Expert
  * Admin
* Login allowed only after registration
* Gmail validation required
* Admin accounts require approval

---

## 🔄 System Workflows

### 🛒 Buyer-Farmer Flow

1. Buyer sends offer
2. Farmer accepts/rejects
3. If accepted → Order created


---

### 👨‍🔬 Expert-Farmer Flow

1. Farmer contacts expert
2. Expert analyzes data
3. Sends crop & fertilizer suggestions

---

### 🛠️ Admin Flow

1. Monitor users/products
2. Handle reports
3. Approve new admins

---

## 🌟 Key Highlights

* Direct farmer-to-buyer marketplace
* Smart crop recommendations
* Secure and scalable architecture

---

## 📦 Installation

```bash
# Clone the repository
git clone https://github.com/your-username/agriconnect.git

# Navigate to project folder
cd agriconnect

# Install frontend dependencies
cd frontend
npm install
npm start

# Install backend dependencies
cd backend
npm install  # or mvn install (Spring Boot)
npm start
```

---

## 📌 Future Enhancements

* 🤖 AI-based crop recommendation
* 📍 Location-based marketplace
* 🌐 Multi-language support (Telugu, Hindi)
* 📈 Advanced analytics dashboard
* 🎙️ Voice assistant for farmers

---

## 🤝 Contributing

Contributions are welcome!
Feel free to fork the repository and submit pull requests.



Developed by **Avinash Gurram**
