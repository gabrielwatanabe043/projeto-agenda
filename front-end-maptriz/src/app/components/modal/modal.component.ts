import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';


@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.scss']
})
export class ModalComponent implements OnInit {

  @Input() public frase: any;
  @Output() public confirm = new EventEmitter();
  constructor() { }

  ngOnInit(): void {
  }

  confirmar(e: any) {
    if (e) {
      this.confirm.emit(e);
    } else {
      this.confirm.emit(e);
    }
  }

}
