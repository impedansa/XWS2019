import React from 'react'
import { connect } from 'react-redux'
import { logout, pageChange } from '../../redux'
import { APARTMENTS, RESERVATIONS, INBOX, LOGIN } from '../../redux/router/routerPaths'

function MenubarContainer({
    loginState,
    logout,
    pageChange
}) {

    return loginState.user != null ? (
        <ul className='menubar'>
            <li><p onClick = { () => pageChange(APARTMENTS) }>Apartments</p></li>
            <li><p onClick = { () => pageChange(RESERVATIONS) }>Reservations</p></li>
            <li><p onClick = { () => pageChange(INBOX) }>Inbox</p></li>
            <li><p onClick = { () => { logout(); pageChange(LOGIN) } }>Logout</p></li>
        </ul>
    ) : (
        <ul className='menubar'>
            <li><p onClick = { () => pageChange(LOGIN) }>Login</p></li>
        </ul>
    )
}

const mapStateToProps = (state) => {
    return {
        loginState: state.loginState
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        logout: () => dispatch(logout()),
        pageChange: (page) => dispatch(pageChange(page))
    }
}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(MenubarContainer)
