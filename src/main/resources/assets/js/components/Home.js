class Home extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
          current_page: 'Orders',
          input_order: {}
        };
    }

    onPageChange(page) {
      this.setState({ current_page: page });
    }

    render() {

        const { orders, current_page, input_order } = this.state;
        let active_component;
        if(current_page == 'Orders') {
            active_component = <OrderIndex />
        }
        else if(current_page == 'Create Order') {
            active_component = <OrderCreate backToOrders={() => this.onPageChange('Orders')} />
        }

        return (
            <div className="container">
                <Header onPageChange={(page) => this.onPageChange(page)} currentPage={current_page} />
                <div className="row">
                    <h3 className="py-2">{current_page}</h3>
                </div>
                {active_component}
            </div>
        );
    }
  }
  
