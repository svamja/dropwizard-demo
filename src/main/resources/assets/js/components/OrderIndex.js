class OrderIndex extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            page: 0,
            orders: [],
        };
    }

    async componentDidMount() {
        let res = await fetch("/api/orders");
        let orders = await res.json();
        this.setState({ orders });
    }

    async paginate(event, page) {
        this.setState({ page });
        event && event.preventDefault();
        page = page || 0;
        let url = "/api/orders?page=" + page;
        let res = await fetch(url);
        let orders = await res.json();
        this.setState({ orders });
    }

    async onDelete(id) {
        let url = '/api/orders/' + id;
        let headers = {
            'Content-Type': 'application/json'
        };
        let method = 'DELETE';
        const response = await fetch(url, { headers, method });
        await this.paginate(null, this.state.page);
    }

    render() {

        const { orders, current_page, input_order } = this.state;
        const paginate = this.paginate.bind(this);
        let order_list = orders.map(order => <Order key={order.id} order={order} onDelete={() => this.onDelete(order.id)} />);

        return (
            <div className="container">
                <div className="row justify-content-end">
                    <div className="col-auto">

                        <ul className="pagination">
                            <li className="page-item">
                                <a className="page-link" href="#" onClick={(event) => paginate(event, 0)}>1</a>
                            </li>
                            <li className="page-item">
                            <a className="page-link" href="#" onClick={(event) => paginate(event, 1)}>2</a>
                            </li>
                            <li className="page-item">
                            <a className="page-link" href="#" onClick={(event) => paginate(event, 2)}>3</a>
                            </li>
                        </ul>

                    </div>
                </div>
                {order_list}
            </div>
        );
    }
  }
  
