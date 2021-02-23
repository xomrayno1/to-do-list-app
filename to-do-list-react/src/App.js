 
import './App.css';
import { useEffect, useState } from 'react';
import queryString from 'query-string'

import ToDoList from './components/ToDo/ToDoList'
import ToDoForm from './components/ToDo/ToDoForm';
import Pagination from './components/ToDo/Pagination'
import PostFilterForm from './components/ToDo/PostFilterForm';
function App() {
  // const [toDo, setToDo] = useState(() => {
  //   return [
  //     {id: 1 , title : 'Gym'},
  //     {id: 2 , title : 'Eat'},
  //     {id: 3 , title : 'Drink'},
  //     {id: 4 , title : 'Work'},
  //   ]
  // });
  const [toDo, setToDo] = useState([])
  const [pagination, setPagination] = useState({
    page:1,
    limit:2,
    totalRows:1
  })
  const [filters, setFilters]  = useState({
    limit: 2, 
    page: 1,
    title: ''
  })

  useEffect(  () => {
    async function fetchToDo(){{
      try {
        const pramsString = queryString.stringify(filters);
        const requestURL = `http://localhost:8080/api/v1/tasks?${pramsString}`;
        const response = await fetch(requestURL);
        const responseJSON = await response.json();
        const { data, pagination }  =  responseJSON;
        setPagination(pagination)
        setToDo(data);
      } catch (error) {
        console.log("failed to fetch"+ error.message)
      }
    }}
    fetchToDo();
  },[filters])

  function onClickedDeleteItem(item){
    let newToDo = [...toDo];
    let index = newToDo.findIndex( (it) => it.id === item.id )
    newToDo.splice(index,1);
    setToDo(newToDo);
  }
  function onSubmit(forms){
     let ids = toDo.map ( item => item.id);
     let max =  Math.max(...ids);
     setToDo([...toDo, {id : max + 1 , title: forms.title}])
  }
  function onHandlePageChange(newPage){
    console.log(newPage)
    setFilters({
      ...filters,
      page: newPage
    })
  }
  function handleFilterChange(forms){
    console.log(forms);
    setFilters({
      ...filters,
      page:1,
      title: forms.search
    })
  }
  return (
    <div className="App">
       <h1>Welcome To App</h1>
       <PostFilterForm onSubmitSearch={handleFilterChange}/>
       <ToDoList  toDo={toDo}  onClickedDeleteItem={onClickedDeleteItem} />
       <Pagination  pagination={pagination} onPageChange={onHandlePageChange} />
       <ToDoForm  onSubmit={onSubmit}/>
    </div>
  );
}

export default App;
