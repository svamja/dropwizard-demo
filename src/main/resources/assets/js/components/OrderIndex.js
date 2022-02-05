class OrderIndex extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
          orders: [],
          current_page: 'Orders',
          input_order: {}
        };
    }

    onPageChange(page) {
      this.setState({ current_page: page });
    }

    async componentDidMount() {
        let res = await fetch("/api/orders");
        let orders = await res.json();
        this.setState({ orders });
    }

    render() {

        const { orders, current_page, input_order } = this.state;
        let active_component;
        if(current_page == 'Orders') {
            let order_list = orders.map(order => <Order key={order.id} order={order} />);
            active_component = order_list;
        }
        else if(current_page == 'Create Order') {
            active_component = <OrderCreate />
        }

        return (
            <div className="container">
                <Header onPageChange={(page) => this.onPageChange(page)} />
                <div className="row">
                    <h3 className="bg-light py-2">{current_page}</h3>
                </div>
                {active_component}
            </div>
        );
    }
  }
  
