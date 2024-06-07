import React from "react";

function DisplayResponse(responseData) {
    
    return(
    responseData ? (
        <div>
            {responseData.content}
        </div>
    ) : (
        <div>Awaiting Response...</div>
    )
    )
}

export default DisplayResponse;