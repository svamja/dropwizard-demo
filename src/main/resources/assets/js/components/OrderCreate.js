class OrderCreate extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            user_id: 1,
            items: []
        };
    }

    componentDidMount() {
        this.addItem();
    }

    getUpdater(field) {
        return (event) => {
            this.setState({ [field]: event.target.value });
        }
    }

    getItemUpdater(id, field) {
        return (event) => {
            let items = [ ...this.state.items ];
            for(let item of items) {
                if(item.id == id) {
                    item[field] = event.target.value;
                    this.setState({ items });
                    break;
                }
            }
        }
    }

    async createOrder() {
        const { onCreate } = this.props;
        let order = { user_id: this.state.user_id, items: this.state.items };
        let url = '/api/orders';
        let headers = {
            'Content-Type': 'application/json'
        };
        let method = 'POST';
        let body = JSON.stringify(order);
        const response = await fetch(url, { headers, method, body });
        onCreate();
    }

    addItem(event) {
        event && event.preventDefault();
        let id = 1;
        if(this.state.items.length) {
            id = this.state.items[this.state.items.length - 1].id + 1;
        }
        let item = { id, name: "", quantity: 0, rate: 0 };
        let items = [ ...this.state.items, item ];
        this.setState({ items });
    }

    render() {

        let createOrder = this.createOrder.bind(this);
        let addItem = this.addItem.bind(this);
        let { user_id } = this.state;
        let item_elements = this.state.items.map(item => (
            <div key={item.id} className="row">
                <div className="col">{item.id}</div>
                <div className="col">
                    <input className="form-control" type="text" value={item.name} onChange={this.getItemUpdater(item.id, 'name')} />
                </div>
                <div className="col">
                    <input className="form-control" type="number" value={item.quantity} onChange={this.getItemUpdater(item.id, 'quantity')} />
                </div>
                <div className="col">
                    <input className="form-control" type="number" value={item.rate} onChange={this.getItemUpdater(item.id, 'rate')} />
                </div>
            </div>
        ));

        return (
            <div>
                <div className="row">
                    <div className="col"> Order # </div>
                    <div className="col"> (New Order) </div>
                </div>
                {/* <div className="row">
                    <div className="col"> User # </div>
                    <div className="col">
                    <input className="form-control" type="number" value={user_id} onChange={this.getUpdater('user_id')} />
                    </div>
                </div> */}
                <div className="row my-2">
                    <div className="col">
                        <a href="#" onClick={addItem}>Add Item</a>
                    </div>
                </div>
                <div className="row">
                    <div className="col">#</div>
                    <div className="col"> Name </div>
                    <div className="col"> Quantity </div>
                    <div className="col"> Rate </div>
                </div>
                {item_elements}
                <div className="row my-2">
                    <div className="col">
                        <button onClick={createOrder} className="btn btn-primary">Create</button>
                    </div>
                </div>
            </div>
        )
    }

}
