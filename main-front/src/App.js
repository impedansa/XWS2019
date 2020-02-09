import React from 'react'
import { Provider } from 'react-redux'
import store from './redux/store'
import './App.css'
import MenubarContainer from './components/menubar/MenubarContainer'
import LoginForm from './components/login/LoginForm'
import InboxContainer from './components/messages/InboxContainer'
import UsersContainer from './components/users/UsersContainer'
import RegistrationForm from './components/login/RegistrationForm'
import CategoriesContainer from './components/apartmentCategories/CategoriesContainer'
import TypesContainer from './components/apartmentTypes/TypesContainer'
import ApartmentsContainer from './components/apartments/ApartmentsContainer'
import ReservationsContainer from './components/reservations/ReservationsContainer'

function App() {
  return (
    <Provider store={ store }>
      <div className="App">
        <MenubarContainer />
        <LoginForm />
        <RegistrationForm />
        <InboxContainer />
        <UsersContainer />
        <CategoriesContainer />
        <TypesContainer />
        <ApartmentsContainer />
        <ReservationsContainer />
      </div>
    </Provider>
  );
}

export default App;
