import React, { useEffect } from 'react'
import { connect } from 'react-redux'
import { fetchUsers } from '../../redux'
import { USERS } from '../../redux/router/routerPaths'
import UserContainer from './UserContainer'
import AgentForm from './AgentForm'

function UsersContainer({
    usersState,
    page,
    fetchUsers
}) {
    useEffect(() => {
        fetchUsers()
    }, [fetchUsers, page])

    return page !== USERS ? (
        ''
    ) : usersState.loading? (
        <h2>Loading...</h2>
    ) : usersState.error ? (
        <h2>{ usersState.error }</h2>
    ) : (
        <div>
            <div>
                <AgentForm />
            </div>
            <div>
                {
                    usersState &&
                    usersState.users &&
                    usersState.users.map((user) => <UserContainer user={ user } />)
                }
            </div>
        </div>
    )
}

const mapStateToProps = (state) => {
    return {
        usersState: state.usersState,
        page: state.route.page
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        fetchUsers: () => dispatch(fetchUsers())
    }
}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(UsersContainer)
