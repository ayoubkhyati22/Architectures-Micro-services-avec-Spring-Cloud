import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddbillComponent } from './add-bill.component';

describe('AddbillComponent', () => {
  let component: AddbillComponent;
  let fixture: ComponentFixture<AddbillComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddbillComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddbillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
