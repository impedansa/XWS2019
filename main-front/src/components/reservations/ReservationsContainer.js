import React, { useEffect } from 'react'
import { connect } from 'react-redux'
import { fetchReservations } from '../../redux'
import ReservationContainer from './ReservationContainer'
import { RESERVATIONS_HISTORY } from '../../redux/router/routerPaths'
import ReservationForm from './ReservationForm'

function ReservationsContainer({
    reservationsState,
    page,
    loginState,
    fetchReservations
}) {
    useEffect(() => {
        if(page === RESERVATIONS_HISTORY) {
            fetchReservations(loginState.user.id)
        }
    }, [page, fetchReservations, loginState])

    return page !== RESERVATIONS_HISTORY ? (
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
        page: state.route.page,
        loginState: state.loginState
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        fetchReservations: (user) => dispatch(fetchReservations(user))
    }
}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(ReservationsContainer)
