import React from 'react';
import { Provider } from 'react-redux'
import store from './redux/store'
import './App.css';
import LoginForm from './components/login/LoginForm';
import MenubarContainer from './components/menubar/MenubarContainer';
import ApartmentsContainer from './components/apartments/ApartmentsContainer';
import ReservationsContainer from './components/reservations/ReservationsContainer';
import InboxContainer from './components/messages/InboxContainer';

function App() {
  return (
    <Provider store={ store }>
      <div className="App">
        <MenubarContainer />
        <LoginForm />
        <ApartmentsContainer />
        <ReservationsContainer />
        <InboxContainer />
      </div>
    </Provider>
  );
}

export default App;
