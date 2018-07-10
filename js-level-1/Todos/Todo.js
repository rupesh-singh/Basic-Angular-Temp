
class Todo {

    constructor(title, completed) {
        Todo.id++;
        this.id = Todo.id;
        this.title = title;
        this.completed = false;
    }



}

Todo.id = 0;

class TodoService {
    constructor() {
        this.todos = []
    }
    addTodo(title) {
        let t = this.todos.concat(title);
        this.todos = t;
    }

    editTodo(id, newTitle) {
        this.todos.findIndex(function (item) {
            if (item.id === id) {
                item.title = newTitle;
            }
        })

    }
    completeTodo(id) {


        this.todos.findIndex(function (item) {
            if (item.id === id) {
                if (item.completed === false)
                    item.completed = true;
                else
                    item.completed = false;
            }
        })




    }


    deleteTodo(id) {
        
        let i=this.todos.findIndex(function(item){
                if(item.id===id)return true;
                return false;
        })
        this.todos.splice(i,1);

    }

    completeAll() {

        this.todos.forEach(function (item) {
            item.completed = true;

        })
    }


    clearCompleted() {
        
        var newProducts = this.todos.filter(function (item) {
            return item.completed===true;
        });
        return newProducts;

    }




    viewTodos(filter) {

        if (filter === "ALL") {
            var newProducts = this.todos.filter(function (item) {
                return item;
            });
            return newProducts;
        }
        else if (filter === "ACTIVE") {
            var newProducts = this.todos.filter(function (item) {
                return item.completed === false;
            });
            return newProducts;
        }
        else if (filter === "COMPLETED") {
            var newProducts = this.todos.filter(function (item) {
                return item.completed === true;
            });
            return newProducts;
        }







        // if (filter === "ALL")
        //     return temp;

        // else if (filter === "ACTIVE") {
        //     for (var t in this.todos) {
        //         if (t.completed === false)
        //             temp.push(t);

        //     }

        // }
        // else if (filter === "COMPLETED") {
        //     for (var t in this.todos) {
        //         if (t.completed === true)
        //             temp.push(t);

        //     }

        // }
        // return temp;

        // filter ==> 'ALL' | 'ACTIVE' | 'COMPLETED'
    }

}

//-------------------------------------------

const todosService = new TodoService();
