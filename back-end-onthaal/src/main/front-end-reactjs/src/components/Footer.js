import React, { Component } from 'react';

class Footer extends Component {
    render() {
        return (
<div className="container paddingBottom30">
  <div className="row border1 paddingTop15">
    <div className="col-sm-4">
      <img src="https://365psd.com/images/previews/ab7/vector-girl-holding-megaphone-25843.jpg" alt="Megaphone image"
           height="100" />
    </div>
    <div className="col-sm-4">

    </div>
    <div className="col-sm-4 alignright paddingBottom30">
      <img src="https://cdn.pixabay.com/photo/2017/08/31/13/10/vacation-2700719_960_720.jpg" alt="Image listener"
           height="100" />
    </div>
  </div>
  <div className="row centrerText">
    &copy;

    Molowayi Ntambwe Alex
  </div>
</div>

        );
    }
}

export default Footer;