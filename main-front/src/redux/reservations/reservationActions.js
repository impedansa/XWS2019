import axios from 'axios'
import { 
    FETCH_RESERVATIONS_REQUEST,
    FETCH_RESERVATIONS_SUCCESS,
    FETCH_RESERVATIONS_ERROR,
    CREATE_RESERVATION_REQUEST,
    CREATE_RESERVATION_SUCCESS,
    CREATE_RESERVATION_ERROR,
    DELETE_RESERVATION_REQUEST,
    DELETE_RESERVATION_SUCCESS,
    DELETE_RESERVATION_ERROR
} from './reservationTypes'

export const fetchReservations = (user) => {
    return (dispatch) => {
        dispatch(fetchReservationsRequest())
        axios.get('http://localhost:8762/apartments-service/users/' + user + '/reservations')
            .then((response) => {
                dispatch(fetchReservationsSuccess(response.data))
            })
            .catch((error) => {
                dispatch(fetchReservationsError(error.message))
            })
    }
}

export const fetchReservationsRequest = () => {
    return {
        type: FETCH_RESERVATIONS_REQUEST
    }
}

export const fetchReservationsSuccess = (apartments) => {
    return {
        type: FETCH_RESERVATIONS_SUCCESS,
        payload: apartments
    }
}

export const fetchReservationsError = (error) => {
    return {
        type: FETCH_RESERVATIONS_ERROR,
        payload: error
    }
}

export const createReservation = (reservation) => {
    return (dispatch) => {
        dispatch(createReservationRequest())
        axios.post('http://localhost:8762/apartments-service/reservations', reservation)
            .then((response) => {
                dispatch(createReservationSuccess(response.data))
            })
            .catch((error) => {
                dispatch(createReservationError(error.message))
            })
    }
}

export const createReservationRequest = () => {
    return {
        type: CREATE_RESERVATION_REQUEST
    }
}

export const createReservationSuccess = () => {
    return {
        type: CREATE_RESERVATION_SUCCESS
    }
}

export const createReservationError = (error) => {
    return {
        type: CREATE_RESERVATION_ERROR,
        payload: error
    }
}

export const deleteReservation = (id) => {
    return (dispatch) => {
        dispatch(deleteReservationRequest())
        axios.delete('http://localhost:8762/apartments-service/reservations/' + id)
        .then((response) => {
            dispatch(deleteReservationSuccess())
        })
        .catch((error) => {
            dispatch(deleteReservationError(error.message))
        })
    }
}

export const deleteReservationRequest = () => {
    return {
        type: DELETE_RESERVATION_REQUEST
    }
}

export const deleteReservationSuccess = () => {
    return {
        type: DELETE_RESERVATION_SUCCESS
    }
}

export const deleteReservationError = (error) => {
    return {
        type: DELETE_RESERVATION_ERROR,
        payload: error
    }
}