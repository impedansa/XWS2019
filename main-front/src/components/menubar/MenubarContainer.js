import React from 'react'
import { connect } from 'react-redux'
import { logout, pageChange } from '../../redux'
import { APARTMENTS, RESERVATIONS_HISTORY, INBOX, LOGIN, TYPES, CATEGORIES, USERS, REGISTRATION } from '../../redux/router/routerPaths'

function MenubarContainer({
    loginState,
    logout,
    pageChange
}) {

    return loginState.user === null ? (
        <ul className='menubar'>
            <li><p onClick = { () => pageChange(LOGIN) }>Login</p></li>
            <li><p onClick = { () => pageChange(REGISTRATION) }>Register</p></li>
        </ul>
    ) : loginState.user.role === 'REGULAR' ? (
        <ul className='menubar'>
            <li><p onClick = { () => pageChange(APARTMENTS) }>Apartments</p></li>
            <li><p onClick = { () => pageChange(RESERVATIONS_HISTORY) }>Reservations</p></li>
            <li><p onClick = { () => pageChange(INBOX) }>Inbox</p></li>
            <li><p onClick = { () => { logout(); pageChange(LOGIN) } }>Logout</p></li>
        </ul>
    ) : loginState.user.role === 'ADMIN' ? (
        <ul className='menubar'>
            <li><p onClick = { () => pageChange(TYPES) }>Types</p></li>
            <li><p onClick = { () => pageChange(CATEGORIES) }>Categories</p></li>
            <li><p onClick = { () => pageChange(USERS) }>Users</p></li>
            <li><p onClick = { () => { logout(); pageChange(LOGIN) } }>Logout</p></li>
        </ul>
    ) : (
        ''
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
