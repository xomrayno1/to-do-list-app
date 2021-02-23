import React from 'react';
import PropTypes from 'prop-types';

ToDoList.propTypes = {
    toDo: PropTypes.array,
    onClickedDeleteItem: PropTypes.func
};
ToDoList.defaultProps = {
    toDo: [],
    onClickedDeleteItem: null
}
function ToDoList(props) {
    const { toDo,onClickedDeleteItem } = props;

    function handleDeleteOnClick(item){
         if(!onClickedDeleteItem){
            return;
         }
         onClickedDeleteItem(item);
    }

    return (
        <div>
            <ul>
                {
                    toDo.map( (item,index) => {
                        return <li key={index} onClick={ ()=> handleDeleteOnClick(item) } >{item.title}</li> ;
                    })
                }
            </ul>
        </div>
    );
}

export default ToDoList;