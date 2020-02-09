import axios from 'axios'
import { FETCH_TYPES_REQUEST, FETCH_TYPES_SUCCESS, FETCH_TYPES_ERROR } from './apartmentTypesTypes'

export const fetchTypes = () => {
    return (dispatch) => {
        dispatch(fetchTypesRequest())
        axios.get('hTtp://localhost:8081/types')
            .then((response) => {
                dispatch(fetchTypesSuccess(response.data))
            })
            .catch((error) => {
                dispatch(fetchTypesError(error.message))
            })
    }
}

export const fetchTypesRequest = () => {
    return {
        type: FETCH_TYPES_REQUEST
    }
}

export const fetchTypesSuccess = (TYPES) => {
    return {
        type: FETCH_TYPES_SUCCESS,
        payload: TYPES
    }
}

export const fetchTypesError = (error) => {
    return {
        type: FETCH_TYPES_ERROR,
        payload: error
    }
}