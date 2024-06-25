import './App.css';
import Users from './components/Users'
import User from './components/User'

import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link,
  useParams
} from "react-router-dom";

function App() {
  return (
      <Router>
        <div>
          <nav>
            <ul>
              <li>
                <Link to="/">Home</Link>
              </li>
              <li>
                <Link to="/about">About</Link>
              </li>
              <li>
                <Link to="/users">Users</Link>
              </li>
            </ul>
          </nav>

          {/* A <Routes> looks through its children <Route>s and
              renders the first one that matches the current URL. */
              //path hangisini gösteriyorsa oradaki elementi çalıştır diyor
            }
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/about" element={<About />} />
            <Route path="/users" element={<Users />} />
            <Route path="/user/:id" element={<User />} />
          </Routes>
        </div>
      </Router>
  );
}

function Home() {
  return <h2>Home</h2>;
}

function About() {
  return <h2>Deli oğlan</h2>;
}
export default App;
