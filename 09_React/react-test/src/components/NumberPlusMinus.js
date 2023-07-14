import React, {Component}  from 'react'; 


class NumberPlusMinus extends Component{
    constructor(props){
        super(props);
        this.state = {count : 0 };

    }

    handleClick = () =>{
        this.setState({ count : this.state.count+1});

    }

    handleClick2 = () => {
        this.setState({count : this.state.count-1});
    }



    render(){
        return(
            <>
            <div>
            <button onClick={this.handleClick2} className='minus'>-</button>
            <h1>{this.state.count}</h1>
            <button onClick={this.handleClick} className='plus' >+</button>
            </div>
            
            </>
        );
    }


    
}
export default NumberPlusMinus;