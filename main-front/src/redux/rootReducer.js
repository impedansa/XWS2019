import { combineReducers } from 'redux'
import routerReducer from './router/routerReducer'
import loginReducer from './login/loginReducer'
import messagesReducer from './messages/messagesReducer'
import usersReducer from './users/usersReducer'
import categoriesReducer from './apartmentCategories/apartmentCategoriesReducer'
import typesReducer from './apartmentTypes/apartmentTypesReducer'
import apartmentsReducer from './apartments/apartmentReducer'
import reservationsReducer from './reservations/reservationReducer'

const rootReducer = combineReducers({
    route: routerReducer,
    loginState: loginReducer,
    messagesState: messagesReducer,
    usersState: usersReducer,
    categoriesState: categoriesReducer,
    typesState: typesReducer,
    apartmentsState: apartmentsReducer,
    reservationsState: reservationsReducer
})

export default rootReducer