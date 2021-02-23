import React from 'react';
import PropTypes from 'prop-types';

Pagination.propTypes = {
    pagination: PropTypes.object.isRequired,
    onPageChange: PropTypes.func
};
Pagination.defaultProps = {
    onPageChange: null
}
function Pagination(props) {
    const { pagination, onPageChange } = props;
    const {page, limit, totalRows}  = pagination; 
    let totalPages =  Math.ceil(pagination.totalRows / pagination.limit);
    function handlePageChange(page){
        onPageChange(page);
    }
    return (
        <div>
            <button disabled = { pagination.page <=  1 } onClick={ ()=> handlePageChange(page - 1)}>Prev</button>
            <button disabled = { pagination.page >= totalPages }  onClick={ ()=> handlePageChange(page + 1)}>Next</button>
        </div>
    );
}

export default Pagination;