import './App.css';
import Header from './Header';
import Footer from './Footer';
import {Route, Link, Routes } from 'react-router-dom';
import RAGDisplay from './RAGDisplay';
import FunctionCallingDisplay from './FunctionCallingDisplay';

function App() {
  return (
    <div className="d-flex flex-column min-vh-100">
      <Header />
      <div className="d-flex flex-grow-1">
        <aside className="bg-secondary text-light p-3">
          <h2>Projects</h2>
          <ul>
            <li>
              <Link to="/RAG">Retrieval Augmented Generation</Link>
            </li>
            <li>
              <Link to="/FunctionCalling">Math Function Calling</Link>
            </li>
          </ul>
        </aside>
        <div className="flex-grow-1 p-3">
          <div>
            <Routes>
              <Route path="/RAG" element={<RAGDisplay />} />
              <Route path="/FunctionCalling" element={<FunctionCallingDisplay />} />
            </Routes>
          </div>
        </div>
      </div>
      <Footer />
    </div>
  );
}

export default App;
