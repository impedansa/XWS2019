import { combineReducers } from 'redux'
import routerReducer from './router/routerReducer'
import apartmentReducer from './apartments/apartmentReducer'
import loginReducer from './login/loginReducer'
import reservationReducer from './reservations/reservationReducer'
import messageReducer from './messages/messagesReducer'
import categoriesReducer from './categories/categoriesReducer'
import apartmentTypesReducer from './apartmentTypes/apartmentTypesReducer'

const rootReducer = combineReducers({
    route: routerReducer,
    apartmentsState: apartmentReducer,
    loginState: loginReducer,
    reservationsState: reservationReducer,
    messagesState: messageReducer,
    categoriesState: categoriesReducer,
    typesState: apartmentTypesReducer
})

export default rootReducer