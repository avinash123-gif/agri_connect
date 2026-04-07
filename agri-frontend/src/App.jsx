import React from 'react';
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import { AuthProvider, useAuth } from './AuthContext';

// Public pages
import Home from './pages/Home';
import Login from './pages/Login';
import Register from './pages/Register';

// Layout
import DashboardLayout from './components/DashboardLayout';

// Farmer pages
import FarmerDashboard from './pages/FarmerDashboard';
import FarmerListings from './pages/FarmerListings';
import FarmerOffers from './pages/FarmerOffers';
import FarmerGuidance from './pages/FarmerGuidance';

// Buyer pages
import BuyerMarketplace from './pages/BuyerMarketplace';
import BuyerOffers from './pages/BuyerOffers';
import BuyerSchemes from './pages/BuyerSchemes';

// Admin pages
import AdminPanel from './pages/AdminPanel';
import AdminUsers from './pages/AdminUsers';
import AdminReports from './pages/AdminReports';
import AdminSchemes from './pages/AdminSchemes';

// Expert page
import ExpertDashboard from './pages/ExpertDashboard';

const RoleRedirect = () => {
    const { user } = useAuth();
    if (!user) return <Navigate to="/login" replace />;

    const role = user.roles?.[0] || 'ROLE_BUYER';

    if (role === 'ROLE_FARMER') return <Navigate to="/farmer" replace />;
    if (role === 'ROLE_ADMIN')  return <Navigate to="/admin"  replace />;
    if (role === 'ROLE_EXPERT') return <Navigate to="/expert" replace />;
    return <Navigate to="/buyer" replace />;
};

function App() {
  return (
    <AuthProvider>
      <BrowserRouter>
        <Routes>
          {/* Public Routes */}
          <Route path="/"         element={<Home />} />
          <Route path="/login"    element={<Login />} />
          <Route path="/register" element={<Register />} />

          {/* Protected Dashboard Routes */}
          <Route element={<DashboardLayout />}>
            {/* Role-based redirect */}
            <Route path="/dashboard" element={<RoleRedirect />} />

            {/* Farmer  */}
            <Route path="/farmer"           element={<FarmerDashboard />} />
            <Route path="/farmer/listings"  element={<FarmerListings />} />
            <Route path="/farmer/offers"    element={<FarmerOffers />} />
            <Route path="/farmer/guidance"  element={<FarmerGuidance />} />

            {/* Buyer */}
            <Route path="/buyer"          element={<BuyerMarketplace />} />
            <Route path="/buyer/offers"   element={<BuyerOffers />} />
            <Route path="/buyer/schemes"  element={<BuyerSchemes />} />

            {/* Admin */}
            <Route path="/admin"          element={<AdminPanel />} />
            <Route path="/admin/users"    element={<AdminUsers />} />
            <Route path="/admin/reports"  element={<AdminReports />} />
            <Route path="/admin/schemes"  element={<AdminSchemes />} />

            {/* Expert */}
            <Route path="/expert"           element={<ExpertDashboard />} />
            <Route path="/expert/broadcast" element={<ExpertDashboard />} />
          </Route>

          {/* Catch-all */}
          <Route path="*" element={<Navigate to="/" replace />} />
        </Routes>
      </BrowserRouter>
    </AuthProvider>
  );
}

export default App;
