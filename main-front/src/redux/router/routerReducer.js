import { PAGE_CHANGE } from './routerTypes'
import { LOGIN } from './routerPaths'

const initialState = {
    page: LOGIN
}

const routerReducer = (state = initialState, action) => {
    switch(action.type) {
        case PAGE_CHANGE: {
            return {
                page: action.payload
            }
        }
        default: return state
    }
}

export default routerReducer