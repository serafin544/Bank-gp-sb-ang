import { Component, OnInit } from '@angular/core';
import { BankService } from '../../services/bank.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent implements OnInit {
  types: string[] = [
    'P2p',
    'Deposit'
  ];
  statuses: string[] = [
    'Pending',
    'Cancelled',
    'Completed'
  ];
  mediums: string[] = [
    'Balance',
    'Rewards'
  ];

  depositform: FormGroup;
  validMessage: string = "";

  constructor(private bankService: BankService) { }

  ngOnInit() {
    this.depositform = new FormGroup({
      id: new FormControl('', Validators.required),
      type: new FormControl('', Validators.required),
      date: new FormControl('', Validators.required),
      status: new FormControl('', Validators.required),
      payeeId: new FormControl('', Validators.required),
      medium: new FormControl('', Validators.required),
      amount: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required)
    })
  }

  submitDeposit(){
    if(this.depositform.valid){
      this.validMessage = "Your bike registration has been submitted. Thank you!";
      this.bankService.createDeposit(this.depositform.value).subscribe(
        data => {
          this.depositform.reset();
          return true;
        },
        error => {
          return Observable.throw(error);
        }
      )
    } else {
      this.validMessage = "Please fill out the form before submitting!";
    }
  }

}
