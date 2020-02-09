import axios from 'axios'
import { FETCH_APARTMENTS_REQUEST, FETCH_APARTMENTS_SUCCESS, FETCH_APARTMENTS_ERROR } from './apartmentTypes'

export const fetchApartments = () => {
    return (dispatch) => {
        dispatch(fetchApartmentsRequest())
        axios.get('http://localhost:8762/apartments-service/apartments')
            .then((response) => {
                dispatch(fetchApartmentsSuccess(response.data))
            })
            .catch((error) => {
                dispatch(fetchApartmentsError(error.message))
            })
    }
}

export const fetchApartmentsRequest = () => {
    return {
        type: FETCH_APARTMENTS_REQUEST
    }
}

export const fetchApartmentsSuccess = (apartments) => {
    return {
        type: FETCH_APARTMENTS_SUCCESS,
        payload: apartments
    }
}

export const fetchApartmentsError = (error) => {
    return {
        type: FETCH_APARTMENTS_ERROR,
        payload: error
    }
}