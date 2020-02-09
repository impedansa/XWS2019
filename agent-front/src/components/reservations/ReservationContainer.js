import React from 'react'
import { connect } from 'react-redux'
import { deleteReservation, confirmReservation } from '../../redux'

function ReservationContainer({
    reservation,
    deleteReservation,
    confirmReservation
}) {
    
    const buttonToRemove = (reservation) => {
        return new Date(reservation.start) > new Date() && reservation.apartment.cancelable ? <button onClick={ () => deleteReservation(reservation.id) }>Cancel</button> : ''
    }
    
    const buttonToConfirm = (reservation) => {
        return new Date(reservation.end) < new Date() && !reservation.realised ? <button onClick={ () => confirmReservation(reservation.id) }>Confirm</button> : ''
    }

    return (
        <div className='element'>
            <table><tbody>
                <tr><td colSpan="2">{ reservation.apartment.city }, { reservation.apartment.address }</td></tr>
                <tr><td colSpan="2">{ reservation.start } - { reservation.end }</td></tr>
                <tr><td>Total:</td><td>{ reservation.price }</td></tr>
                <tr><td>{ buttonToRemove(reservation) }{ buttonToConfirm(reservation) }</td></tr>
            </tbody></table>
        </div>
    )
}

const mapDispatchToProps = (dispatch) => {
    return {
        deleteReservation: (id) => dispatch(deleteReservation(id)),
        confirmReservation: (id) => dispatch(confirmReservation(id))
    }
}

export default connect(
    mapDispatchToProps
)(ReservationContainer)
