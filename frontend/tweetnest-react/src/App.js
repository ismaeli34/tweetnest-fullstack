import logo from './logo.svg';
import './App.css';
import HomePage from './components/HomePage/HomePage';
import Authentication from './components/Authentication/Authentication.';
import { Route,Routes } from 'react-router-dom';

function App() {
  return (
    <div className="">

      <Routes>
        <Route path="/*" element={true?<HomePage/> : <Authentication/>}>

    

        </Route>
            
        </Routes>

    </div>
  );
}

export default App;
