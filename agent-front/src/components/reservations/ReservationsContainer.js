import React, { useEffect } from 'react'
import { connect } from 'react-redux'
import { fetchReservations } from '../../redux'
import ReservationContainer from './ReservationContainer'
import { RESERVATIONS } from '../../redux/router/routerPaths'
import { resetReservations } from '../../redux'
import ReservationForm from './ReservationForm'

function ReservationsContainer({
    reservationsState,
    page,
    fetchReservations,
    resetReservations
}) {
    useEffect(() => {
        if(page === RESERVATIONS) {
            fetchReservations()
        } else {
            resetReservations()
        }
    }, [page, fetchReservations, resetReservations])

    return page !== RESERVATIONS ? (
        ''
    ) : reservationsState.loading ? (
        <h2>Loading...</h2>
    ) : reservationsState.error ? (
        <h2>{ reservationsState.error }</h2>
    ) : (
        <div>
            <aside>
                <ReservationForm />
            </aside>
            <div>
                {
                reservationsState &&
                reservationsState.reservations &&
                reservationsState.reservations.map((reservation) => <ReservationContainer reservation={ reservation } />)
                }
            </div>
        </div>
    )
}

const mapStateToProps = (state) => {
    return {
        reservationsState: state.reservationsState,
        page: state.route.page
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        fetchReservations: () => dispatch(fetchReservations()),
        resetReservations: () => dispatch(resetReservations())
    }
}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(ReservationsContainer)
