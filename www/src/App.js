import "./App.css";
import { Route, Routes } from "react-router-dom";
import {
  Header,
  Landing,
  Footer,
  Login,
  Signup,
  CompleteSignup,
  Feed,
  Profile,
  Jobs,
  NotFound,
  Recruiter,
  Connections,
  Admin,
  AdminLogin,
} from "./components";

import { AuthProvider } from "./contexts/AuthContext";
import { UserRoutes } from "./contexts/AuthRoute";
function App() {
  return (
    <div id="app_container" className="m-0 min-h-screen flex flex-col">
      <AuthProvider>
        <Header />
        <div id="app_content" className="my-0 flex flex-1 flex-col float-none">
          <Routes>
            <Route path="/" element={<Landing />} />
            <Route path="/login" element={<Login />} />
            <Route path="/signup" element={<Signup />} />
            <Route path="/signup/complete" element={<CompleteSignup />} />
            <Route element={<UserRoutes />}>
              <Route path="/feed" element={<Feed />} />
              <Route path="/profile" element={<Profile />} />
              <Route path="/jobs" element={<Jobs />} />
              <Route path="/recruiter" element={<Recruiter />} />
              <Route path="/connections" element={<Connections />} />
              <Route path="/admin/login" element={<AdminLogin />} />
              <Route path="/admin" element={<Admin />} />
              <Route path="*" element={<NotFound />} />
            </Route>
          </Routes>
        </div>
        <Footer />
      </AuthProvider>
    </div>
  );
}

export default App;
