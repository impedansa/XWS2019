import React from 'react'

function MessageContainer({
    message,
    senderId
}) {
    return (
        <div className={ message.senderId !== senderId ? 'right-message element' : 'left-message element' }>
            <table>
                <tbody>
                    <tr>
                        <td>{ message.text } ( { message.time } )</td>
                    </tr>
                </tbody>
            </table>
        </div>
    )
}

export default MessageContainer
