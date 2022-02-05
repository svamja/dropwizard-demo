class OrderCreate extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            id: 5,
            items: []
        };
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
                }
            }
        }
    }

    async createOrder() {
        let order = { id: this.state.id, items: this.state.items };
        let url = '/api/orders';
        let headers = {
            'Content-Type': 'application/json'
        };
        let method = 'POST';
        let body = JSON.stringify(order);
        console.log(order);
        const response = await fetch(url, { headers, method, body });
        console.log(response);
    }

    onAddItem(event) {
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
        let onAddItem = this.onAddItem.bind(this);
        let item_elements = this.state.items.map(item => (
            <div key={item.id}>
                <div>Item# {item.id}</div>
                <div>
                    <input type="text" value={item.name} onChange={this.getItemUpdater(item.id, 'name')} />
                </div>
            </div>
        ));

        return (
            <div>
                <div className="row">
                    <div className="col">
                        Order #
                    </div>
                    <div className="col">
                        <input type="number" value={this.state.id} onChange={this.getUpdater('id')} />
                    </div>
                </div>
                <div className="row my-2">
                    <div className="col">
                        <button className="btn btn-primary" onClick={onAddItem}>Add Item</button>
                    </div>
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
