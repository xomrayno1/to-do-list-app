import React, { useRef, useState } from 'react';
import PropTypes from 'prop-types';

PostFilterForm.propTypes = {
    onSubmitSearch: PropTypes.func
};
PostFilterForm.defaultProps= {
    onSubmitSearch: null
}

function PostFilterForm(props) {
    const [toDoSearch, setTodoSearch] =   useState('');
    const { onSubmitSearch } = props
    const typingTimeourRef = useRef(null);
  
    function handleOnChangeSearch(e){
        const value = e.target.value
        
        setTodoSearch(value);
        
        if(!onSubmitSearch) return ;        

        if(typingTimeourRef.current){
            clearTimeout(typingTimeourRef.current)
        }
         
        typingTimeourRef.current = setTimeout( () => {
            const forms = {
                search : value
            };
            onSubmitSearch(forms);
        },300)
         
    }
   
    return (
        <div>
             
                <input  type='text' value={toDoSearch} onChange={handleOnChangeSearch}  placeholder='Nhập tìm kiếm...' />
             
        </div>
    );
}

export default PostFilterForm;