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
import { UserRoutes as AuthRoutes } from "./routes/AuthRoute";
import { ProfileRoute } from "./routes/ProfileRoute";
import { ProfileProvider } from "./contexts/ProfileContext";

function App() {
  return (
    <div id="app_container" className="m-0 min-h-screen flex flex-col">
      <AuthProvider>
        <ProfileProvider>
          <Header />
          <div
            id="app_content"
            className="my-0 flex flex-1 flex-col float-none"
          >
            <Routes>
              <Route path="/" element={<Landing />} />
              <Route path="/login" element={<Login />} />
              <Route path="/signup" element={<Signup />} />
              <Route path="/signup/complete" element={<CompleteSignup />} />
              <Route element={<AuthRoutes />}>
                <Route path="/feed" element={<Feed />} />
                <Route element={<ProfileRoute />}>
                  <Route path="/profile" element={<Profile />} />
                </Route>
                <Route path="/jobs" element={<Jobs />} />
                <Route path="/recruiter" element={<Recruiter />} />
                <Route path="/connections" element={<Connections />} />
                <Route path="/admin/login" element={<AdminLogin />} />
                <Route path="/admin" element={<Admin />} />
              </Route>
              <Route path="*" element={<NotFound />} />
            </Routes>
          </div>
          <Footer />
        </ProfileProvider>
      </AuthProvider>
    </div>
  );
}

export default App;
