import { PAGE_CHANGE } from './routerTypes'

export const pageChange = (page) => {
    return {
        type: PAGE_CHANGE,
        payload: page
    }
}