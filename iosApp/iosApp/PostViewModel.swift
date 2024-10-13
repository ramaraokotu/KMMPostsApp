//
//  PostViewModel.swift
//  iosApp
//
//  Created by itsupport on 12/10/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared
import SwiftUI
import Combine

class PostViewModel: ObservableObject {
    @Published private(set) var  displayPosts: [Post] = []
    @Published var isLoading: Bool = false
    @Published var viewState: ViewState = .loading {
        willSet {
            isLoading = (newValue == .loading)
        }
    }

    private var allPostsList: [Post] = []
    private var postRepository: PostRepositoryWrapper
    
    init(with postRepository: PostRepositoryWrapper = PostRepositoryWrapper()) {
        self.postRepository = postRepository
    }
    
}

extension PostViewModel {
    func getPosts() {
        viewState = .loading
        DispatchQueue.main.async {
            Task {
                do {
                    let response = try await self.postRepository.invoke()
                    self.viewState = .content
                    self.allPostsList = response
                    self.displayPosts = self.allPostsList
                } catch {
                    self.viewState = .error
                }
            }
        }
    }
}


enum ViewState {
    case loading
    case content
    case error
}


