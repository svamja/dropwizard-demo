class OrderCreate extends React.Component {

    constructor(props) {
        super(props);
        this.state = { id: 5 };
    }

    getUpdater(field) {
        return (event) => {
            this.setState({ [field]: event.target.value });
        }
    }

    async createOrder() {
        let order = { id: this.state.id };
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

    render() {

        let createOrder = this.createOrder.bind(this);

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
                <div className="row">
                    <div className="col">
                        <button onClick={createOrder} className="btn btn-primary">Create</button>
                    </div>
                </div>
            </div>
        )
    }

}
