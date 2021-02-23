import React, { useState } from 'react';
import PropTypes from 'prop-types';

ToDoForm.propTypes = {
    onSubmit: PropTypes.func
};
ToDoForm.defaultProps = {
    onSubmit: null
}
function ToDoForm(props) {
    const [toDoItem, setToDoItem] = useState('');
    const { onSubmit } = props
    function handleOnChange(e){
        setToDoItem(e.target.value)
    }
    function handleOnSubmit(e){
        e.preventDefault();
        if(!onSubmit){ return ;}
        const forms = {
            title : toDoItem
        }
        onSubmit(forms);
        setToDoItem('')
    }
    return (
        <div>
             <form onSubmit={handleOnSubmit}>
                 <input type='text' value={toDoItem} 
                                onChange={handleOnChange} placeholder='Nhập thêm....'/> 
             </form>
        </div>
    );
}

export default ToDoForm;